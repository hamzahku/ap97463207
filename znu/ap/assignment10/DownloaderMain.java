package assignment10;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DownloaderMain {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter URL : ");
        String link = sc.next();
        
        System.out.println("Please Enter Path : ");
        String path = sc.next();
        
        System.out.println("Please Enter a number to stop downloading : ");
        int stop = sc.nextInt();
        
        int thread_num = 1;
        System.out.println("Please Enter Number of thread that you want : (Defualt is 1)");
        thread_num = sc.nextInt();
        
        
        Queue <String> q = new LinkedList<String>();
        q.add(link);
        
        Set<String> set_links = new HashSet();
        //String path = "C:\\Users\\phoenix71\\Documents\\NetBeansProjects\\downloader";
        
        Configuration lmit_dl_conf = new Configuration(stop ,q, set_links);
        for (int i=0;i<thread_num;i++){
            Thread_DL t1 = new Thread_DL(  lmit_dl_conf, path);
            t1.start();
        }
        

 }
}
class Thread_DL implements Runnable {
    Configuration _dl_conf;
    String path;
    Thread downloader_th;
    Thread_DL( Configuration config , String path_save) {
        _dl_conf = config;
        path = path_save;
    }
 @Override
    public void run() {
        //download_page and save it
        while(_dl_conf.get_limit_dl()>=1 && _dl_conf.q.size()!=0){
            //System.out.println( _dl_conf.q.size());
            download_page_extract_links();
        }
    }
    public void start() {
        if (downloader_th == null) {
            downloader_th = new Thread(this);
            downloader_th.start();
        }
    }
    
    
    public synchronized String get_link(){
        String link = _dl_conf.pop_q();
        return link;
    }
    public  void download_page_extract_links(){
        String link = get_link();
        String file_name = Integer.toString(link.hashCode());
        String addr = path+"\\"+file_name;
        InputStream in;
        InputStream in_wr;
          
        try {
            
            //System.out.println(downloader_th.getName()+" "+limit_dl_conf.get_limit_dl());
            //System.out.println(downloader_th.getName()+" "+link);
            in = new URL(link).openStream();
            in_wr = new URL(link).openStream(); 
            Files.copy(in_wr, Paths.get(addr), StandardCopyOption.REPLACE_EXISTING);
            _dl_conf.update_limit_dl();
            _dl_conf.update_counter();
            if(_dl_conf.get_counter_ten()==0){
                System.out.println(Integer.toString(_dl_conf.counter_downloaded)+" "+Integer.toString(_dl_conf.q.size()));
                _dl_conf.reset_counter_ten();
            }
            
            String html = convertInputStreamToString(in);
            String regex = "<a href\\s?=\\s?\"([^\"]+)\">";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(html);
            int index = 0;
            while (matcher.find(index)) {
                
                String within_link = matcher.group(1); //Extract links
                String domain_org_link = getDomainName(link);
                String domin_within_link = getDomainName(within_link);
                
                if (!domain_org_link.equals(domin_within_link) && !domin_within_link.equals("")){
                    index = matcher.end();
                    continue;
                }
                    
                if (within_link.substring(0, 1).equals("/")){
                    within_link = domain_org_link+within_link;
                }
                
                if(getProtocol(link)!=null && !within_link.substring(0, 4).equals("http")){
                    within_link = getProtocol(link)+"://"+within_link;
                }
                    
                
                if(!check_existance_link(within_link)){
                    //update Queue and Set
                    update_Q_and_set(within_link);
                }
                
                index = matcher.end();
            }
            
        } catch (MalformedURLException ex) {
            //Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } catch (IOException ex) {
            //Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }
    
    private static String convertInputStreamToString(InputStream inputStream) throws IOException {

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }

        return result.toString(StandardCharsets.UTF_8.name());

    }
    
    public boolean check_existance_link(String link){
        boolean exist = false;
        if (_dl_conf.get_set().contains(link))
            exist = true;
        return exist;
    }
    
    
    public  String getDomainName(String url)  {
        String domain = "";
        try {
            URI uri = new URI(url);
            domain = uri.getHost();
            if(domain == null)
                return  "";
            domain =  domain.startsWith("www.") ? domain.substring(4) : domain;
//            String domain_cp = domain;
//            int count_subdomain = domain_cp.length() - domain_cp.replace(".", "").length()-1;
//            if(count_subdomain>0){
//                System.out.println("fdklsjfklsj   "+domain);
//                String [] splits = domain.split(".");
//                String sub_domain_name = splits[0]+".";
//                String result = domain.replaceFirst(Pattern.quote(sub_domain_name), "");
//                domain = result;
//            }
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(Thread_DL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  domain;
    }
    
    public String getProtocol(String link){
        URL url;
        String protocol = null;
        try {
            url = new URL(link);
            protocol = url.getProtocol();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Thread_DL.class.getName()).log(Level.SEVERE, null, ex);
            return protocol;
        }
        
        return protocol;
    }
    
    public  synchronized void update_Q_and_set(String link){
        _dl_conf.set_q(link);
        //update set
        _dl_conf.set_set(link);
    }
}
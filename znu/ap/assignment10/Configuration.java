/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment10;

import java.util.Queue;
import java.util.Set;


public class Configuration {
    int limit_dl;
    Queue<String> q;
    Set<String> downloaded_links;
    
    int counter_ten;
    int counter_downloaded;

    public Configuration(int dl , Queue<String> links , Set<String> set_links ) {
        limit_dl = dl;
        q = links;
        downloaded_links = set_links;
        counter_downloaded = 0;
        counter_ten = 10;
    }
    
    public  int get_limit_dl(){
        return  limit_dl;
    }
    
    public void set_limit_dl(int dl){
        limit_dl = dl;
    }
    
    public void update_limit_dl(){
        limit_dl -= 1;
    }
    
    public String pop_q(){
        return q.poll();
    }
    
    public  void set_q(String str){
        q.add(str);
    }
    
    public void set_set(String str){
        downloaded_links.add(str);
    }
    
    public  Set get_set(){
        return downloaded_links;
    }
    
    public int get_counter_dl(){
        return  counter_downloaded;
    }
    
    public void update_counter(){
        counter_downloaded ++;
        counter_ten --;
    }
    
    public int get_counter_ten(){
        return  counter_ten;
    }
    
    public void reset_counter_ten(){
        counter_ten = 10;
    }
    
}

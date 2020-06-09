package com.cache;

import com.cache.customLruCache.CustomCacheKey;
import com.cache.customLruCache.CustomCacheValue;
import com.cache.multilevelCache.IMultiLevelCache;
import com.cache.multilevelCache.MultilevelCache;

import java.util.Scanner;

public class CacheController {

        public static void main(String[] args) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Welcome to multiLevel cache stimulator!!");
            System.out.println("Enter the cache levels you require:");
            int levels = reader.nextInt();
            IMultiLevelCache<CustomCacheKey, CustomCacheValue<String>> multiLevelCache = new MultilevelCache<>(2,levels);

            while(true) {
                System.out.println("Choose any one operation");
                System.out.println("1. add key value pair in cache");
                System.out.println("2. get value for particular key");
                System.out.println("3. remove particular key from cache");
                System.out.println("4. show the whole cache");
                int choice = reader.nextInt();
                switch(choice) {
                    case 1:
                        System.out.println("Enter the key:");
                        int key = reader.nextInt();
                        reader.nextLine();
                        System.out.println("Enter a name for your key");
                        String name = reader.nextLine();
                        System.out.println("Enter the corresponding value:");
                        String value = reader.nextLine();
                        multiLevelCache.add(new CustomCacheKey(key,name) , new CustomCacheValue<>(value));
                        System.out.println("The given key value added to cache sucessfully!!");
                        break;
                    case 2:
                        System.out.println("Enter key you need to search:");
                        int findKey = reader.nextInt();
                        reader.nextLine();
                        System.out.println("Enter name for the key");
                        String findName = reader.nextLine();
                        System.out.println(multiLevelCache.get(new CustomCacheKey(findKey,findName)));
                        break;
                    case 3:
                        System.out.println("Enter the key to remove:");
                        int removeKey = reader.nextInt();
                        reader.nextLine();
                        System.out.println("Enter a name for your key to remove");
                        String removeName = reader.nextLine();
                        multiLevelCache.remove(new CustomCacheKey(removeKey,removeName));
                        System.out.println("Key sucessfully removed!!");
                        break;
                    case 4:
                        multiLevelCache.show();
                        break;
                    default:
                        System.out.println("Enter correct option!!");
                    }

            }
        }
}

package com.example.cunsumer.utils;

import javax.ejb.Stateless;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jboss.logging.Logger;

@Stateless(name = "FileManagerImpl")
public class FileManagerImpl implements FileManager{

    private static final Logger logger= Logger.getLogger(FileManagerImpl.class.getName());
    @Override
    public void toFile(int middle) {
        logger.info(middle);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\1.txt")))
        {
            bw.write(String.valueOf(middle));
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

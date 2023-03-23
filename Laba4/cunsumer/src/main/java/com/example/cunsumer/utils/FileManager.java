package com.example.cunsumer.utils;

import javax.ejb.Local;

@Local
public interface FileManager {
    void toFile(int middle);
    
}

package com.example.cunsumer.service;

import com.example.cunsumer.utils.FileManager;
import com.example.cunsumer.utils.FileManagerImpl;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless(name = "GradeService")
public class GradeServiceImpl implements GradeService {

    private static final Logger logger= Logger.getLogger(GradeServiceImpl.class.getName());
    @EJB(beanName = "FileManagerImpl")
    private FileManager fileManager;

    @Override
    public void calculate(String grades) {
        logger.info(grades);
        String grade = grades.trim();
        String[] myInt = grade.split(" ");
        int middle = (Integer.parseInt(myInt[0])  +  Integer.parseInt(myInt[1]) + Integer.parseInt(myInt[2])) / 3;
        fileManager.toFile(middle);
    }
}

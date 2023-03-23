package com.example.cunsumer.service;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface GradeService {

    void calculate(String grades);

}

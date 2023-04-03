/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.universityws.beans;

import co.edu.javeriana.as.universityws.model.Students;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author julia
 */
@Local
public interface StudentsFacadeLocal {

    void create(Students students);

    void edit(Students students);

    void remove(Students students);

    Students find(Object id);

    List<Students> findAll();

    List<Students> findRange(int[] range);

    int count();
    
}

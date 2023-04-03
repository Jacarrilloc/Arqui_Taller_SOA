package co.edu.javeriana.as.universityws.service;

import co.edu.javeriana.as.universityws.beans.StudentsFacade;
import co.edu.javeriana.as.universityws.beans.StudentsFacadeLocal;
import co.edu.javeriana.as.universityws.model.Students;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


@WebService(serviceName = "StudentsWebService")
public class StudentsWebService {

    @EJB
    private StudentsFacade local;

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "insertar")
    public String insertar(@WebParam(name = "id") Integer id, @WebParam(name = "nombre") String nombre, @WebParam(name = "carrera") String carrera) {
        Students nuevo = new Students(id, nombre, carrera);
        local.create(nuevo);
        Students db = local.find(id);
        return db.toString();
    }

    @WebMethod(operationName = "editar")
    public String editar(@WebParam(name = "id") Integer id, @WebParam(name = "nombre") String nombre, @WebParam(name = "carrera") String carrera) {
        Students estudiante = local.find(id);
        if (estudiante != null) {
            estudiante.setNombre(nombre);
            estudiante.setCarrera(carrera);
            local.edit(estudiante);
            return estudiante.toString();
        } else {
            return "No se encontró el estudiante con id: " + id;
        }
    }

    @WebMethod(operationName = "eliminar")
    public String eliminar(@WebParam(name = "id") Integer id) {
        Students estudiante = local.find(id);
        if (estudiante != null) {
            local.remove(estudiante);
            return "El estudiante con id " + id + " ha sido eliminado correctamente.";
        } else {
            return "No se encontró el estudiante con id: " + id;
        }
    }

}

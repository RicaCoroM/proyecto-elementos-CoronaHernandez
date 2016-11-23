
package org.unitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorMensaje {

    @Autowired
    RepositorioMensajes repoMensa;
    //Primero hacemos el metodo para guardar

    @CrossOrigin
    @RequestMapping(value = "/mensaje/{titulo}/{cuerpo}", method = RequestMethod.POST, headers = {"Accept=text/html"})
    public String guardar(@PathVariable String titulo, @PathVariable String cuerpo) {
        repoMensa.save(new Mensaje(titulo, cuerpo));
        return "Mensaje guardado con exito";
    }

//buscar todos
    @CrossOrigin
    @RequestMapping(value = "/mensaje", method = RequestMethod.GET, headers = ("Accept=application/json"))
    public String buscarTodos() throws Exception {
        ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) repoMensa.findAll();
        ObjectMapper maper = new ObjectMapper();
        return maper.writeValueAsString(mensajes);
    }

//buscar por id
    @CrossOrigin
    @RequestMapping(value = "/mensaje/{id}", method = RequestMethod.GET, headers = ("Accept=application/json"))
    public String buscarId(@PathVariable Long id) throws Exception {
        Mensaje mensa = repoMensa.findOne(id);
        ObjectMapper maper = new ObjectMapper();
        return maper.writeValueAsString(mensa);
    }

//actualizar    
    @CrossOrigin
    @RequestMapping(value = "mensaje/{id}/{titulo}/{cuerpo}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public String actualizar(@PathVariable Long id, @PathVariable String titulo, @PathVariable String cuerpo) {
        Mensaje mensa = new Mensaje(id, titulo, cuerpo);
        repoMensa.save(new Mensaje(id, titulo, cuerpo));
        return "Mensaje actualizado con exito;";
    }

    //borrar ID
    @CrossOrigin
    @RequestMapping(value = "mensaje/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public String borrarPorId(@PathVariable Long id) throws Exception {
        repoMensa.delete(id);
        return "mensaje borrado";

    }

}

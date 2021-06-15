package com.PedroNel.Domain.Controller;

import com.PedroNel.Domain.Entities.CategoriaEntity;
import com.PedroNel.Domain.Repository.CategoriaRepository;
import com.PedroNel.Domain.Servicies.Interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/1")
    public int numero(){



        try {
            //categoriaService.insPrimerId();

            return categoriaRepository.lastIdCategoria().getIdCategoria();

        }catch (Exception e)
        {
            categoriaRepository.insertarPrimerId();

            return categoriaRepository.lastIdCategoria().getIdCategoria();
        }

    }

    @GetMapping("/2")
    public String test2(){


        categoriaRepository.insertarPrimerId();

        return "insertado";
    }

    @GetMapping("/3")

    public int test3(){

        return categoriaRepository.contadorByNombre("tecno");
    }

    @GetMapping("/4")

    public Set<CategoriaEntity>mostrar(int limi  ,int offset)
    {


        return categoriaRepository.ConsultaCategoriaPag(1,0);
    }
}

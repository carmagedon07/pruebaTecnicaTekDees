package com.PedroNel.Domain.Controller;


import com.PedroNel.Domain.DTO.CategoriaDTO1;
import com.PedroNel.Domain.DTO.ProductoDTO1;
import com.PedroNel.Domain.Servicies.Interfaces.CategoriaService;
import com.PedroNel.Domain.Servicies.Interfaces.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OperacionesRest {

    @Autowired
    CategoriaService catSer;

    @Autowired
    ProductoService prodSer;

    //Rest producto
///////////////////////////////producto
    //***consulta
   // @GetMapping("/Producto")

    //****insertar
    @PostMapping("/producto")
    public ResponseEntity <String> addProducto(@RequestBody ProductoDTO1 podD){
        int count;
        String nameProducto;

        nameProducto=podD.getNombreProducto();

        count = prodSer.counterbyNameProduct(nameProducto);

        if(count==0){

            prodSer.insProducto(podD);


            return new ResponseEntity<>("Producto creado", HttpStatus.CREATED);

        }else{
            return new ResponseEntity<>("ya exite el producto", HttpStatus.FORBIDDEN);
        }



    }

    //**update categoria
    @PutMapping(value ="/producto/{id}")
    public ResponseEntity<String>updateCategoria(@RequestBody ProductoDTO1 podD,@PathVariable("id")Integer id){
        String mensaje;
        try{
            mensaje=prodSer.actualizacionProducto(podD,id);


            if(mensaje =="Actualizado el producto"){
                return new ResponseEntity<>(mensaje, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
            }

        }
        catch(Exception e){
            return new ResponseEntity<>("operacion no permitida", HttpStatus.FORBIDDEN);
        }
    }
//eliminar
    @DeleteMapping(value ="/producto/{id}")
    public ResponseEntity<String>deleteProducto(@PathVariable("id")int id){

        prodSer.eliminarproducto(id);


        return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);
    }



    //Rest Categoria
    /////////////////////////////////////Producto
    //***consulta
    // @GetMapping("/categoria")

    //****insertar
    @PostMapping("/categoria")
    public ResponseEntity <String> addCategoria(@RequestBody CategoriaDTO1 cate){
        int count;
        String nameCategoria;

        nameCategoria=cate.getNombreCategoria();

        count = catSer.counterbyName(nameCategoria);

        if(count==0){
            catSer.insCategoria(cate);

            return new ResponseEntity<>("creada categorida", HttpStatus.CREATED);

        }else{
            return new ResponseEntity<>("ya exite la categorida", HttpStatus.FORBIDDEN);
        }



    }

    //**update categoria
    @PutMapping(value ="/categoria/{id}")
    public ResponseEntity<String>updateCategoria(@RequestBody CategoriaDTO1 cate,@PathVariable("id")Integer id){
        String mensaje;
        try{
            mensaje=catSer.actualizacionCategoria(cate,id);

            if(mensaje =="Actualizada la categoria"){
                return new ResponseEntity<>(mensaje, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
            }

        }
        catch(Exception e){
            return new ResponseEntity<>("operacion no permitida", HttpStatus.FORBIDDEN);
        }
    }
    //eliminar
    @DeleteMapping(value ="/categoria/{id}")
    public ResponseEntity<String>deleteCategoria(@PathVariable("id")int id){

        catSer.eliminarCategoria(id);

        return new ResponseEntity<>("Categoria eliminada", HttpStatus.OK);
    }

}

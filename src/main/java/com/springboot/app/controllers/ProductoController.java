package com.springboot.app.controllers;

import com.springboot.app.models.Producto;
import com.springboot.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller /*@SessionAttributes(value = "producto")*/
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @RequestMapping("/listar")
    public String Home(Model model, @RequestParam(value = "InputFilter",defaultValue = "") String word){
        List<Producto> listaProducts=productoService.listAll(word);
        model.addAttribute("ListProducts",listaProducts);
        model.addAttribute("keyword",word);
        System.out.println("word : "+word);
        model.addAttribute("title","Spring CRUD");
        /* String prueba=(String) model.asMap().get("error");*/
        return "index";
    }

    @RequestMapping("/form")
    public String formulario(Model model){
        Producto producto=new Producto();
        model.addAttribute("producto",producto);
        String subTitle="";
        model.addAttribute("title","Formulario Producto XD");
        model.addAttribute("SubTitle","Crear Producto");
        return "form";
    }

    @PostMapping(value ="/guardar" )
    public String agregar(/*@ModelAttribute("producto") */Producto producto){
        System.out.println(producto.toString());
        productoService.save(producto);
        return "redirect:listar";
    }

    @RequestMapping(value = "/delete/{id}")
        public String delete(@PathVariable("id") Long id, Model model, RedirectAttributes redirect){
        productoService.delete(id);
        redirect.addFlashAttribute("warning","El usuario ha sido eliminado");
        return "redirect:/listar"; /* Si no le pongo '/' haria una peticion a /delete/listar  */
    }

    @RequestMapping(value = "/editar/{id}")
    public String editar(@PathVariable Long id,Model model, RedirectAttributes redirect){
       Producto producto=productoService.get(id);
       if(producto==null){
           redirect.addFlashAttribute( "error","No existe el codigo de usuario seleccionado por favor intente de nuevo");
           return "redirect:/listar";
       }
        System.out.println(producto);
        model.addAttribute("producto",producto);
        model.addAttribute("SubTitle","Editar Producto");
       return "form";
    }
    }


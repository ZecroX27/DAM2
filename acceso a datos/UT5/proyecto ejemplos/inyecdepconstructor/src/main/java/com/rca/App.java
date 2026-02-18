package com.rca;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        BeanFactory factory = new ClassPathXmlApplicationContext("app-context.xml");
        Libro libro = (Libro) factory.getBean("libro");
        System.out.println("- " + libro.getTitulo());
        System.out.println("- " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellido());
        // observa que no le asignamos editorial en app-context.xml
        System.out.println("- " + libro.getEditorial());
        System.out.println("- " + libro.getGenero());
        System.out.println("- " + libro.getEdicion());
        System.out.println("- " + libro.getPaginas());
    }
}

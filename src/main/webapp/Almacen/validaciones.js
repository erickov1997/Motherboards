
function validar(form){
    var nombre= form["agrAlmc:nom"].value;
    var descripcion= form["agrAlmc:desc"].value;
    var direccion= form["agrAlmc:direc"].value;
    var expr=/^([0-9])*$/;
    
    if (nombre=="") {
        event.preventDefault();
        //alert("El campo nombre se encuentra vacio");
         $("#agrAlmc").append("<h2 id="nomb">nombre vacio</h2>");
        return false;
    }else if(nombre.length>10){
         event.preventDefault();
        //alert("La longitud del campo nombre es muy larga");
        $("#agrAlmc").append("<h2>La longitud del campo nombre es muy larga</h2>");
        return false;
    }else if(expr.test(nombre)){ 
        event.preventDefault();
          event.preventDefault();
         /*$("#agrAlmc").append("<h2>nombre vacio</h2>");*/
          //alert("El campo nombre solo puede contener letras"); 
          $("#agrAlmc").append("<h2>El campo nombre solo puede contener letras</h2>");
         return false;
     }else if(descripcion===""){
         event.preventDefault();
         //event.preventDefault();
           /*$("#agrAlmc").append("<h2>descripcion vacio</h2>");*/
              //alert("El campo descripcion esta vacio"); 
              $("#agrAlmc").append("<h2>El campo descripcion esta vacio</h2>");
              return false;
     }else if(direccion===""){  
       event.preventDefault();
       /*$("#agrAlmc").append("<h2>direcion vacio</h2>"); */
       $("#agrAlmc").append("<h2>El campo direccion esta vacio</h2>");
          //alert("El campo direccion esta vacio"); 
         return false;
     }else{
         alert("Registro exitoso"); 
        
        /* $("#agrAlmc").append("<h2>rEgistro exitoso</h2>");*/
         return true;
     }

}


function showMessage(){
    event.preventDefault();
   alert("Hello World!");	
}


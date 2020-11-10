
function validar(form){
    var nombre= form["agrAlmc:nom"].value;
    var descripcion= form["agrAlmc:desc"].value;
    var direccion= form["agrAlmc:direc"].value;
    var expr=/^([0-9])*$/;
    
     if(expr.test(nombre)){ 
          //event.preventDefault();
         /*$("#agrAlmc").append("<h2>nombre vacio</h2>");*/
          alert("formato no valido"); 
         return false;
     }else if(nombre.length==0 || nombre.length>5){
         //event.preventDefault();
           /*$("#agrAlmc").append("<h2>descripcion vacio</h2>");*/
              alert("El campo nombre esta vacio"); 
        
         return false;
     }
     else if(descripcion===""){
         //event.preventDefault();
           /*$("#agrAlmc").append("<h2>descripcion vacio</h2>");*/
              alert("El campo descripcion esta vacio"); 
        
         return false;
     }else if(direccion===""){
        //event.preventDefault();
       /*$("#agrAlmc").append("<h2>direcion vacio</h2>"); */
          alert("El campo direccion esta vacio"); 
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


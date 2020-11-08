
function validar(form){
    var nombre= form["agrAlmc:nom"].value;
    var descripcion= form["agrAlmc:desc"].value;
    var direccion= form["agrAlmc:direc"].value;
    
     if(nombre===""){ 
          event.preventDefault()
         $("#agrAlmc").append("<h2>nombre vacio</h2>");
         return false;
     }else if(descripcion===""){
         event.preventDefault()
           $("#agrAlmc").append("<h2>descripcion vacio</h2>");
        
         return false;
     }else if(direccion===""){
        event.preventDefault()
       $("#agrAlmc").append("<h2>direcion vacio</h2>"); 
         return false;
     }else{
         alert("Registro exitoso"); 
         return true;
     }

}


function showMessage(){
    event.preventDefault();
   alert("Hello World!");	
}


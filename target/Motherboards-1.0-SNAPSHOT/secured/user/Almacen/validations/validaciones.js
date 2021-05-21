function validar(){
    var nombre, apellido,numero;
     nombre=document.getElementById("nom").value;
     apellido=document.getElementById("des").value;
     numero=document.getElementById("num").value;

     if(nombre===""){
         alert("nombre vacio");
         return false;
     }else if(apellido.equals("") ){
        alert("nombre vacio");
        return false;
     }else if(numero.length===0){
         
     }

}


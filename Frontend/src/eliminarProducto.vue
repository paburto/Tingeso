<template>
    <div class="container">
      <br>
      <h4 style="text-align:left; font-family:georgia"> <strong>Eliminar Producto</strong></h4>
      <br>
      <div class="col">
        <div class="row">
          <div>
          Nombre del producto: <input v-model="nombre_producto" style="margin-left: 10px">
          </div>
       </div>
       <br>
       <div class="row">
          Código del producto: <input v-model="codigo_producto" style="margin-left: 20px">
        </div>
      </div>

      <div class="center">

        <button type = "button" class="btn btn-success" style="float: left;" @click="deleteProducto">
              Eliminar Producto
      </button>

      </div>
    </div>
</template>

<script>
import axios from 'axios';

const localhost = 'http://localhost:8081';
export default {
  components: {
  },
  data(){
    return{
      nombre_producto:'',
      codigo_producto:'',
      productos: [],
      errors: []
    }
  },
  methods: {
    getProductos(){
      var url = localhost + '/productos';
      axios.get(url).then((data) => {
        this.productos = data.data;
      });
    },
    deleteProducto() {
      var url = localhost + '/productos/delete/';
      var id;
      for(let i = 0;i < this.productos.length; i++){
        if(this.productos[i].nombre_producto == this.nombre_producto && this.productos[i].codigo_producto == this.codigo_producto){
          id = this.productos[i].id;
          console.log(id);
        }
      }
      var idString = "" + id;
      url = url + idString;
      axios.delete(url, {
        id: id
      })
      .then(response => {
        this.nombre_producto = "";
        this.codigo_producto = "";
      })
      .catch(e => {
        this.errors.push(e)
      })
    },
  },
  mounted() {
    this.getProductos();
  }
}
</script>

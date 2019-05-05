<template>
    <div class="container">
      <br>
      <h4 style="text-align:left; font-family:georgia"> <strong>Listar Productos </strong></h4>
      <br>
      <div class="col">
        <div class="row">
            <br><br><br><br>
            <!--Combobox-->
            <label for="select">Seleccione una categoria:</label>
            <br><br>
                  <div class="styled-select slate" style="margin-left: 10px">
                       <select v-model="categoria_seleccionado">
                       <option @click.prevent="seleccionarCategoria"
                           style="width: 100px; font-family: georgia"
                           v-for="categoria in categorias"
                           v-bind:key="categoria.id_categoria"
                           v-bind:value="categoria.id_categoria"> {{ categoria.nombre_categoria }}
                       </option>
                       </select>
                  </div>
            <br>
       </div>
       <br>
       <div class="row">
            <!--Lista de productos filtrados-->
            <ul class="list-group">
                <li v-for="producto in productos_filtrados"
                    style = "height: 50px; font-family: georgia; text-align: center"
                    class = "list-group-item"> {{ producto.nombre_producto}}  ${{ producto.precio}}
                    <br>
                </li>
                <br>
            </ul>
            <br>
            <br>
        </div>
      </div>
    </div>
</template>

<script>
    export default {
        components: {
        },
        data(){
            return{
                selected: '',
                categorias: [
                    {
                        id_categoria: 1,
                        nombre_categoria: "Importado",
                    },
                    {
                        id_categoria: 2,
                        nombre_categoria: "Nacional",
                    },
                ],
                productos: [
                    {
                        id_producto: 1,
                        nombre_producto: "Arroz",
                        id_categoria: 1,
                        precio:1590
                    },
                    {
                        id_producto: 2,
                        nombre_producto: "Lechuga",
                        id_categoria: 1,
                        precio:1000
                    },
                    {
                        id_producto: 3,
                        nombre_producto: "Clorogel",
                        id_categoria: 2,
                        precio:299
                    }
                ],
                productos_filtrados: [],
                categoria_seleccionado: 0,
            }
        },
        methods: {
            seleccionarCategoria(){
                //Se seleccionan los productos correspondientes a esa categoría seleccionada
                this.productos_filtrados = [];
                for(let i = 0; i < this.productos.length; i++){
                    if(this.productos[i].id_categoria == this.categoria_seleccionado){
                        this.productos_filtrados.push(this.productos[i]);
                    }
                }

            },
        }
    }
</script>

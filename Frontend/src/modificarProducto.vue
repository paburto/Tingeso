<template>
    <div class="container">
      <br>
      <h4 style="text-align:left; font-family:georgia"> <strong>Modificar Producto</strong></h4>
      <br>
      <div class="col">
        <div class="row">
          <div>
            Nombre del producto: <input v-model="nombre_producto" style="margin-left: 20px">
          </div>
       </div>
       <br>
       <div class="row">
          Código del producto: <input v-model="codigo_producto" style="margin-left: 28px">
        </div>
        <br>
        <div class="row">
          Categoría del producto: <input v-model="codigo_producto" style="margin-left: 10px">
         </div>
         <br>
         <div class="row">
          Fecha de vencimiento: <input v-model="codigo_producto" style="margin-left: 15px">
          </div>
          <br>
          <div class="row">
          Precio del producto: <input v-model="codigo_producto" style="margin-left: 35px">
           </div>
      </div>
      <div class="center">

        <button type = "button" class="btn btn-success" style="float: left;">
              Modificar Producto
      </button>

      </div>
    </div>
</template>

<script>

</script>

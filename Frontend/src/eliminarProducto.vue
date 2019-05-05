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

        <button type = "button" class="btn btn-success" style="float: left;">
              Eliminar Producto
      </button>

      </div>
    </div>
</template>

<script>

</script>

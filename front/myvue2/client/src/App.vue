<template>
  <h1>{{ message }}</h1>
</template>
<script>
  const options = {
    data: function(){
      return {
        message: '您好'
      };
    }
  };
  export default options;
</script>
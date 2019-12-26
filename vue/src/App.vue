<template>

  <div id="app">
    <div id= "back">
    <Home></Home>
    <img alt="Cat foot" src="./assets/cat.png" style="width:200px;">
  </div>
  </div>
</template>

<script>
import Home from './components/Home.vue'

export default {
  name: 'app',
  components: {
    Home
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  
}
#back {
  margin-top : 0px;
  background-image: url("./assets/new.jpeg");
  background-size: 100%; 
}
</style>

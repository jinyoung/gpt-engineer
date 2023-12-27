<template>
  <div id="app">
    <TaskNode :task="rootTask" />
  </div>
</template>

<script>
import TaskNode from './components/TaskNode.vue';

export default {
  name: 'App',
  components: {
    TaskNode
  },
  data() {
    return {
      rootTask: {
        id: 'root',
        title: 'Root Task',
        importance: 5,
        children: [],
        createdAt: new Date()
      }
    };
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
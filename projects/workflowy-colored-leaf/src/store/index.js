import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    tasks: {}
  },
  mutations: {
    // Mutations will be added here to handle task updates
  },
  actions: {
    // Actions will be added here to interact with Firebase
  },
  modules: {
    // Modules can be added here if needed
  }
});
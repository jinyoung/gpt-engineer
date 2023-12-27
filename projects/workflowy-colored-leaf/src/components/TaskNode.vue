<template>
  <div :style="nodeStyle">
    <div>{{ task.title }} ({{ task.importance }})</div>
    <div v-if="showChildren">
      <TaskNode
        v-for="child in task.children"
        :key="child.id"
        :task="child"
      />
    </div>
    <button @click="toggleChildren">Toggle</button>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import { computeNodeColor } from '../utils/colorUtils';

export default {
  name: 'TaskNode',
  props: {
    task: Object
  },
  data() {
    return {
      showChildren: true
    };
  },
  computed: {
    ...mapState(['tasks']),
    nodeStyle() {
      return {
        color: computeNodeColor(this.task.importance, this.task.createdAt),
        border: '1px solid #ddd',
        padding: '10px',
        margin: '10px'
      };
    }
  },
  methods: {
    toggleChildren() {
      this.showChildren = !this.showChildren;
    }
  }
};
</script>
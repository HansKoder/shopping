<template>
  <div>The Detail id is: {{ postId }}</div>
</template>

<script lang="ts">
import { useRoute } from "vue-router";

// Libraries
import { ref, onMounted, computed } from "vue";

export default {
  name: "ClothesView",
  setup() {
    // Variables
    let entity = ref({});

    // Methodos
    const getClothesById = async () => {
      console.log("Hello..");
    };

    const route = useRoute();
    const postId = computed(() => route.params.id);

    onMounted(() => getClothesById());

    return {
      entity,
      postId,
    };
  },
};
</script>

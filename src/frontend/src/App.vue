<template>
  <AsideComponent />

  <main
    class="lg:absolute lg:left-[260px] w-full lg:w-9/12 2xl:w-10/12 p-5 lg:pl-10"
  >
    <router-view />
  </main>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import AsideComponent from "@/components/Aside.vue"; // @ is an alias to /src

export default defineComponent({
  name: "App",
  components: {
    AsideComponent,
  },
});
</script>

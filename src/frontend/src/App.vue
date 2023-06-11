<template>
  <div class="flex flex-wrap">
    <aside-menu-component />
    <main class="flex-auto px-2 py-2">
      <router-view />
    </main>
  </div>
</template>

<style>
.size {
  width: max-content;
}
</style>

<script lang="ts">
import { defineComponent } from "vue";
import AsideMenuComponent from "@/components/AsideMenu.vue"; // @ is an alias to /src

export default defineComponent({
  name: "App",
  components: {
    AsideMenuComponent,
  },
});
</script>

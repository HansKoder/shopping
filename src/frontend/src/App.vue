<template>
  <!-- 
<div class="flex flex-wrap">
    <button class="bg-yellow-500 text-white md:hidden absolute">
      Menu Mobile
    </button>
    <aside
      class="bg-pink-700 text-white hidden h-26 md:block font-medium w-[260px]"
    >
      Menu.
    </aside>
    <main
      class="bg-pink-100 text-gray-900 font-medium h-26 flex-auto text-center"
    >
      <p>Hello world.</p>
    </main>
  </div>

 -->

  <div class="flex flex-wrap">
    <aside-component />
    <main class="bg-pink-100 text-gray-900 font-medium h-48 w-full text-center">
      <p>Hello world.</p>
    </main>
  </div>

  <!-- lg:absolute lg:left-[260px] w-full lg:w-9/12 2xl:w-10/12 p-5 lg:pl-10 -->

  <!-- 
<AsideComponent />

  <main
    class="lg:absolute lg:left-[260px] block border-4 border-red-800 w-full hidden"
  >
    <router-view />
  </main>    
   -->
</template>

<style>
.size {
  width: max-content;
}
</style>

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

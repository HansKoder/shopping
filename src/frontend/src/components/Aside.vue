<template>
  <!-- Menu Device Mobile -->
  <button class="absolute text-white text-4xl top-5 left-4" @click="openbar()">
    <i class="bi bi-filter-left px-2 bg-pink-700 rounded-md"></i>
  </button>

  <!-- Menu 
  sidebar fixed top-0 bottom-0 lg:left-0 left-[-260px] p-2 w-[260px] overflow-y-auto text-center bg-pink-700 bloc
  -->
  <aside
    class="sidebar fixed lg:left-0 left-[-260px] top-0 bottom-0 lg:left-0 left-[-260px] p-2 w-[260px] overflow-y-auto text-center bg-pink-700 md:block"
  >
    <!-- Title -->
    <div class="text-gray-100 text-xl">
      <div class="p-2.5 mt-1 flex items-center">
        <h1 class="font-bold text-gray-200 text-[15px] ml-3">Shopping</h1>
        <i
          class="bi bi-x ml-[70px] cursor-pointer text-[30px] lg:hidden"
          @click="openbar()"
        ></i>
      </div>
      <hr class="my-2 text-gray-600" />
    </div>

    <!-- Home -->
    <div
      class="p-2.5 mt-3 flex items-center rounded-md px-4 duration-300 cursor-pointer hover:bg-blue-600 text-white"
    >
      <i class="bi bi-house-door-fill"></i>
      <router-link to="/" class="text-[15px] ml-4 text-gray-200"
        >Home</router-link
      >
    </div>

    <!-- Purchase -->
    <div
      class="p-2.5 mt-3 flex items-center rounded-md px-4 duration-300 cursor-pointer hover:bg-blue-600 text-white"
    >
      <i class="bi bi-cart-fill"></i>
      <router-link to="/about" class="text-[15px] ml-4 text-gray-200"
        >Purchase</router-link
      >
    </div>

    <!-- Clothes -->
    <div
      class="p-2.5 mt-3 flex items-center rounded-md px-4 duration-300 cursor-pointer hover:bg-blue-600 text-white"
    >
      <i class="bi bi-shop"></i>
      <router-link to="/clothes" class="text-[15px] ml-4 text-gray-200"
        >Clothes</router-link
      >
    </div>

    <hr class="my-4 text-gray-600" />

    <!-- Logout -->
    <div
      class="p-2.5 mt-3 flex items-center rounded-md px-4 duration-300 cursor-pointer hover:bg-blue-600 text-white"
    >
      <i class="bi bi-box-arrow-in-right"></i>
      <span class="text-[15px] ml-4 text-gray-200">Logout</span>
    </div>
  </aside>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "AsideComponent",
  methods: {
    openbar: function () {
      const sideBar = document.querySelector(".sidebar");
      if (!sideBar) return;
      sideBar.classList.toggle("left-[-260px]");
    },
  },
});
</script>

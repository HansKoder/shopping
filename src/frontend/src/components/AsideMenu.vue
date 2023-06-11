<template>
  <aside
    class="bg-pink-600 min-h-screen text-white font-semibold px-4 duration-500 hidden md:block"
    :class="[open ? 'w-48' : 'w-16']"
  >
    <!-- Icon close and open -->
    <div class="py-3 flex justify-end">
      <i class="bi bi-justify cursor-pointer text-xl" @click="setOpen"></i>
    </div>

    <!-- Items -->
    <div class="mt-4 flex flex-col gap-4 relative">
      <router-link
        class="group flex items-center text-sm gap-3.5 font-medium p-2 rounded-md"
        v-for="(item, index) in items"
        :key="index"
        :to="item.path"
      >
        <div>
          <i
            class="bi bi-house-door-fill cursor-pointer text-xl"
            :class="item.icon"
          ></i>
        </div>
        <h2
          :style="{ 'transition-delay': index + '00ms' }"
          class="whitespace-pre duration-500"
          :class="!open ? 'opacity-0 translate-x-28 overflow-hidden' : ''"
        >
          {{ item.title }}
        </h2>
        <h2
          class="absolute left-48 bg-white font-semibold whitespace-pre text-gray-900 rounded-md drop-shadow-lg px-0 py-0 w-0 overflow-hidden group-hover:px-2 group-hover:py-1 group-hover:left-14 group-hover:duration-300 group-hover:w-fit"
          :class="open ? 'hidden' : ''"
        >
          {{ item.title }}
        </h2>
      </router-link>
    </div>
  </aside>
</template>

<script lang="ts">
// Libraries
import { ref } from "vue";

export default {
  name: "AsideMenu",
  setup() {
    const home = {
      icon: "bi bi-house-door-fill ",
      title: "Home",
      path: "/",
    };

    const clothes = {
      icon: "bi bi-shop",
      title: "Clothes",
      path: "/clothes",
    };

    const items = [home, clothes];

    let open = ref(true);

    const setOpen = () => {
      console.log("Set Open");
      open.value = !open.value;
    };

    return { items, setOpen, open };
  },
};
</script>

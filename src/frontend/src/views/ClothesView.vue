<template>
  <section class="mt-[1px]">
    <h1 class="text-pink-600 font-bold text-5xl text-center font-black mb-8">
      Clothes
    </h1>

    <div v-if="!showForm">
      <button
        class="bg-pink-600 text-white text-md font-semibold rounded-md m-2 px-5 py-1 right-[0px]"
        @click="handlerShowForm"
      >
        Add Clothes
      </button>

      <ExampleModal />
    </div>

    <!-- Form -->
    <section v-if="showForm">
      <FormClothes />
    </section>

    <!-- Show When There is nothing Data -->
    <Info
      v-if="clothes.length == 0"
      msg="There is nothing data of clothes is our DB"
    />

    <!-- Show to Web -->
    <div class="hidden md:block" v-if="clothes.length > 0">
      <table class="w-full">
        <thead class="bg-pink-200 border-b-2 border-pink-500 text-pink-500">
          <tr>
            <th class="w-20 p-3 text-sm font-semibold tracking-wide text-left">
              Img
            </th>
            <th class="p-3 text-sm font-semibold tracking-wide text-left">
              Description
            </th>
            <th class="w-20 p-3 text-sm font-semibold tracking-wide text-left">
              Size
            </th>
            <th class="w-32 p-3 text-sm font-semibold tracking-wide text-left">
              Brand
            </th>
            <th class="w-32 p-3 text-sm font-semibold tracking-wide text-left">
              Options
            </th>
          </tr>
        </thead>
        <tbody>
          <tr
            class="bg-rose-100 border-b-2 border-pink-500 p-[100px]"
            v-for="(item, index) in clothes"
            :key="index"
          >
            <td class="p-2">
              <img
                class="w-12 h-12 rounded-full mx-auto"
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCPOVdt5RW3yQa3mDbaf8PlvN6PqsMLUFr1y7FwqDSu9BPTkS_HAXzo4BrXoIr9BfXRts&usqp=CAU"
                alt=""
                width="384"
                height="512"
              />
            </td>
            <td class="text-gray-700 p-3 text-sm">
              {{ item.name }}
            </td>
            <td class="text-gray-700 p-3 text-sm">
              {{ item.detailSize }}
            </td>
            <td class="text-gray-700 p-3 text-sm">
              {{ item.brand }}
            </td>
            <td class="text-gray-700 p-3 text-sm">
              <router-link
                :to="'/clothes/detail/' + index"
                class="bg-gray-500 hover:bg-gray-600 px-2 py-1 text-white font-semibold rounded-md text-xs cursor-pointer"
              >
                Detail
              </router-link>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="hidden md:gap-3 md:columns-2 lg:columns-3">
      <div
        class="bg-red-200 text-white font-bold border-x-4 border-pink-500 mb-5 p-5 w-full block"
      >
        01
      </div>
      <div
        class="bg-red-200 text-white font-bold border-x-4 border-pink-500 mb-5 p-5 w-full block"
      >
        02
      </div>
      <div
        class="bg-red-200 text-white font-bold border-x-4 border-pink-500 mb-5 p-5 w-full block"
      >
        03
      </div>
    </div>

    <!-- class="grid grid-cols-1 gap-4 lg:hidden m-2 w-full bg-rose-300 rounded-md border-b-4 border-pink-500" -->

    <!-- Show Devices Mobiles -->
    <div v-if="clothes.length > 0" class="w-full">
      <figure
        class="flex bg-rose-100 rounded-xl p-6 md:p-0 border-b-4 border-pink-500 mb-2 md:hidden"
        v-for="(item, index) in clothes"
        :key="index"
      >
        <img
          class="w-24 h-24 rounded-full mx-auto"
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCPOVdt5RW3yQa3mDbaf8PlvN6PqsMLUFr1y7FwqDSu9BPTkS_HAXzo4BrXoIr9BfXRts&usqp=CAU"
          alt=""
        />
        <div class="pt-2 md:p-2 text-center space-y-4">
          <p class="text-lg font-medium">
            {{ item.name }}
          </p>
          <div class="font-medium">
            <div class="text-sky-500">{{ item.brand }}</div>
            <div class="text-slate-700">Size: {{ item.detailSize }}</div>
          </div>
        </div>
      </figure>
    </div>
  </section>
</template>

<script lang="ts">
// Services
import clothesService from "../services/ClothesService";

// Libraries
import to from "await-to-js";
import { ref, onMounted } from "vue";

// Components
import Info from "@/components/Info.vue";
import FormClothes from "@/components/FormClothes.vue";
import ExampleModal from "@/components/ExampleModal.vue";

export default {
  name: "ClothesView",
  setup() {
    // Variables
    let clothes = ref([]);
    let showForm = ref(false);

    // Methodos
    const getClothes = async () => {
      const [err, data] = await to(clothesService.getAll());
      console.log(err);
      console.log(data);

      if (err) return;

      clothes.value =
        !data || !data.data || !data.data.data ? [] : data.data.data;
    };

    const handlerShowForm = () => {
      showForm.value = !showForm.value;
    };

    onMounted(() => getClothes());

    return {
      clothes,
      showForm,
      handlerShowForm,
    };
  },
  components: {
    Info,
    FormClothes,
    ExampleModal,
  },
};
</script>

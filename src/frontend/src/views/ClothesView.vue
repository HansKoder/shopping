<template>
  <section class="mt-[20px] lg:mt-[10px]">
    <h1 class="text-white font-bold text-5xl text-center font-black mb-8">
      Clothes
    </h1>

    <div class="mb-2" v-if="!showForm">
      <button
        class="bg-blue-400 text-white text-md font-semibold rounded-md m-2 px-5 py-1 w-full md:w-1/12"
        @click="handlerShowForm"
      >
        Add
      </button>
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
    <div class="hidden lg:block" v-if="clothes.length > 0">
      <table class="w-full">
        <thead class="bg-gray-50 border-b-2 border-gray-200">
          <tr>
            <th class="w-20 p-3 text-sm font-semibold tracking-wide text-left">
              Code
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
          </tr>
        </thead>
        <tbody>
          <tr class="bg-white" v-for="(item, index) in clothes" :key="index">
            <td class="text-gray-700 p-3 text-sm text-center">
              {{ index }}
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
          </tr>
        </tbody>
      </table>
    </div>

    <!-- Show Devices Mobiles -->
    <div v-if="clothes.length > 0" class="w-full">
      <article
        class="grid grid-cols-1 gap-4 lg:hidden m-2 w-full"
        v-for="(item, index) in clothes"
        :key="index"
      >
        <div class="bg-white p-4 rounded-lg shadow w-full">
          <div class="flex items-center space-x-2 text-sm">
            <div>{{ item.id }}</div>
            <div>{{ item.name }}</div>
            <div>{{ item.detailSize }}</div>
          </div>

          <div class="text-md text-gray-700">{{ item.brand }}</div>
        </div>
      </article>
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
  },
};
</script>

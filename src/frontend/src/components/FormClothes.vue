<template>
  <form class="mb-[40px]">
    <div class="mb-3">
      <label
        for="description"
        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >Description</label
      >
      <input
        type="text"
        id="description"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
        placeholder="Description"
        v-model="state.name"
      />
      <span class="block text-red-400 text-sm ml-1" v-if="v$.name.$error">
        {{ v$.name.$errors[0].$message }}
      </span>
    </div>

    <div class="mb-3">
      <label
        for="category"
        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >Category</label
      >
      <input
        type="text"
        id="category"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
        placeholder="Pants, T-shirt etc.."
        v-model="state.category"
      />
      <span class="block text-red-400 text-sm ml-1" v-if="v$.category.$error">
        {{ v$.category.$errors[0].$message }}
      </span>
    </div>

    <div class="mb-3">
      <label
        for="detailSize"
        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >detailSize</label
      >
      <select
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
        v-model="state.detailSize"
      >
        <option value="">-- select --</option>
        <option value="M/M">M/M</option>
        <option value="S">S</option>
        <option value="XL">XL</option>
      </select>
      <span class="block text-red-400 text-sm ml-1" v-if="v$.detailSize.$error">
        {{ v$.detailSize.$errors[0].$message }}
      </span>
    </div>

    <div class="mb-3">
      <label
        for="brand"
        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >Brand</label
      >
      <select
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
        v-model="state.brand"
      >
        <option value="">-- select --</option>
        <option value="ESSENTIALS">ESSENTIALS</option>
        <option value="ARTURO CALLE">ARTURO CALLE</option>
        <option value="LEVIS">LEVIS</option>
      </select>
      <span class="block text-red-400 text-sm ml-1" v-if="v$.brand.$error">
        {{ v$.brand.$errors[0].$message }}
      </span>
    </div>

    <div class="mb-3">
      <button
        type="button"
        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 mr-[5px]"
        @click="submitForm"
      >
        Save
      </button>
      <button
        type="button"
        @click="cancelForm"
        class="text-white bg-gray-700 hover:bg-gray-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
      >
        Cancel
      </button>
    </div>
  </form>
</template>

<script lang="ts">
// Services
import clothesService from "../services/ClothesService";

// Libraries
import to from "await-to-js";
import { reactive } from "vue"; // "from '@vue/composition-api'" if you are using Vue <2.7
import { useVuelidate } from "@vuelidate/core";
import { required } from "@vuelidate/validators";

export default {
  setup() {
    // Form
    const state = reactive({
      name: "",
      detailSize: "",
      brand: "",
      category: "",
    });
    const rules = {
      name: { required }, // Matches state.name
      detailSize: { required }, // Matches state.detailSize
      brand: { required }, // Matches state.brand
      category: { required }, // Matches state.category
    };

    const v$ = useVuelidate(rules, state);

    // Methods
    const submitForm = async () => {
      v$.value.$validate(); // checks all inputs
      if (v$.value.$error) {
        console.log("Errors");
        return;
      }

      console.log("Continue...");
      console.log(state);

      const [err, response] = await to(clothesService.save(state));

      console.log(err);
      console.log(response);
    };

    const cancelForm = () => {
      console.log("Cancel Form..");
    };

    return { state, v$, submitForm, cancelForm };
  },
};
</script>

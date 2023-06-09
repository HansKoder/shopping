<template>
  <main-title title="Add Clothes" />

  <form class="mb-[40px] bg-pink-100 px-5 pt-10 pb-5 rounded-lg">
    <div class="mb-3">
      <label
        for="description"
        class="block mb-2 text-md font-medium text-pink-600"
        >Description</label
      >
      <input
        type="text"
        id="description"
        class="bg-pink-100 border border-pink-300 text-sm rounded-lg block w-full p-2.5 focus:outline-none focus:border-pink-500 focus:ring-1 focus:ring-pink-500 disabled:bg-slate-50 disabled:text-slate-500 disabled:border-slate-200 disabled:shadow-none invalid:border-pink-500 invalid:text-pink-600 focus:invalid:border-pink-500 focus:invalid:ring-pink-500 text-gray-800 font-medium"
        placeholder="T-Shirt - Pink"
        v-model="state.name"
      />
      <span
        class="block text-red-500 font-semibold text-sm ml-1 mt-1 mb-5"
        v-if="v$.name.$error"
      >
        * {{ v$.name.$errors[0].$message }}
      </span>
    </div>

    <div class="mb-3">
      <label for="img" class="block mb-2 text-md font-medium text-pink-600"
        >Image (URL)</label
      >
      <input
        type="text"
        id="img"
        class="bg-pink-100 border border-pink-300 text-sm rounded-lg block w-full p-2.5 focus:outline-none focus:border-pink-500 focus:ring-1 focus:ring-pink-500 disabled:bg-slate-50 disabled:text-slate-500 disabled:border-slate-200 disabled:shadow-none invalid:border-pink-500 invalid:text-pink-600 focus:invalid:border-pink-500 focus:invalid:ring-pink-500 text-gray-800 font-medium"
        placeholder="Enter an URL.."
        v-model="state.img"
      />
      <span
        class="block text-red-500 font-semibold text-sm ml-1 mt-1 mb-5"
        v-if="v$.img.$error"
      >
        * {{ v$.img.$errors[0].$message }}
      </span>
    </div>

    <div class="mb-3">
      <label for="category" class="block mb-2 text-md font-medium text-pink-600"
        >Category</label
      >
      <input
        type="text"
        id="category"
        class="bg-pink-100 border border-pink-300 text-sm rounded-lg block w-full p-2.5 focus:outline-none focus:border-pink-500 focus:ring-1 focus:ring-pink-500 disabled:bg-slate-50 disabled:text-slate-500 disabled:border-slate-200 disabled:shadow-none invalid:border-pink-500 invalid:text-pink-600 focus:invalid:border-pink-500 focus:invalid:ring-pink-500 text-gray-800 font-medium"
        placeholder="T-Shirt - Pants - Jeans etc.."
        v-model="state.category"
      />
      <span
        class="block text-red-500 font-semibold text-sm ml-1 mt-1 mb-5"
        v-if="v$.category.$error"
      >
        * {{ v$.category.$errors[0].$message }}
      </span>
    </div>

    <div class="mb-3">
      <label
        for="detailSize"
        class="block mb-2 text-md font-medium text-pink-600"
        >Size</label
      >
      <select
        class="bg-pink-100 border border-pink-300 text-sm rounded-lg block w-full p-2.5 focus:outline-none focus:border-pink-500 focus:ring-1 focus:ring-pink-500"
        v-model="state.detailSize"
      >
        <option value="">-- select --</option>
        <option value="M/M">M/M</option>
        <option value="S">S</option>
        <option value="XL">XL</option>
      </select>
      <span
        class="block text-red-500 font-semibold text-sm ml-1 mt-1 mb-5"
        v-if="v$.detailSize.$error"
      >
        * {{ v$.detailSize.$errors[0].$message }}
      </span>
    </div>

    <div class="mb-3">
      <label for="brand" class="block mb-2 text-md font-medium text-pink-600"
        >Brand</label
      >
      <select
        class="bg-pink-100 border border-pink-300 text-sm rounded-lg block w-full p-2.5 focus:outline-none focus:border-pink-500 focus:ring-1 focus:ring-pink-500"
        v-model="state.brand"
      >
        <option value="">-- select --</option>
        <option value="ESSENTIALS">ESSENTIALS</option>
        <option value="ARTURO CALLE">ARTURO CALLE</option>
        <option value="LEVIS">LEVIS</option>
      </select>
      <span
        class="block text-red-500 font-semibold text-sm ml-1 mt-1 mb-5"
        v-if="v$.brand.$error"
      >
        * {{ v$.brand.$errors[0].$message }}
      </span>
    </div>

    <div class="mb-3 mt-5 text-right">
      <button
        type="button"
        class="text-white bg-pink-600 hover:bg-pink-700 rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center mb-1 font-medium font-semibold mr-[5px]"
        @click="submitForm"
      >
        Save
      </button>
      <button
        type="button"
        @click="cancelForm"
        class="text-black bg-pink-400 hover:bg-pink-500 rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center mb-1 font-semibold mr-[5px]"
      >
        Cancel
      </button>
    </div>
  </form>
</template>

<script lang="ts">
// Services
import clothesService from "../../services/ClothesService";

// Libraries
import to from "await-to-js";
import { reactive } from "vue"; // "from '@vue/composition-api'" if you are using Vue <2.7
import { useVuelidate } from "@vuelidate/core";
import { required } from "@vuelidate/validators";
import MainTitle from "@/components/MainTitle.vue";

export default {
  name: "AddClothesView",
  setup() {
    // Form
    const state = reactive({
      name: "",
      detailSize: "",
      brand: "",
      category: "",
      img: "",
    });
    const rules = {
      name: { required }, // Matches state.name
      detailSize: { required }, // Matches state.detailSize
      brand: { required }, // Matches state.brand
      category: { required }, // Matches state.category
      img: { required }, // Matches state.category
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
  components: { MainTitle },
};
</script>

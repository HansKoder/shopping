<template>
  <figure
    class="flex bg-rose-100 rounded-xl p-6 md:p-0 border-b-4 border-pink-500 mb-2 md:hidden"
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
</template>
<script lang="ts">
export default {
  name: "MainTitleComponent",
  props: ["item"],
};
</script>

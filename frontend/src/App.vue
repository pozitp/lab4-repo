<template>
  <router-view />
</template>

<script>
export default {
  name: "App",
  async mounted() {
    try {
      const response = await fetch('/api/features');
      if (response.ok) {
        const flags = await response.json();
        const themeAmber = flags.find(f => f.name === 'THEME_AMBER');
        if (themeAmber && themeAmber.enabled) {
          document.body.classList.add('theme-amber');
        } else {
          document.body.classList.remove('theme-amber');
        }
      }
    } catch (error) {
      console.error('Failed to fetch feature flags:', error);
    }
  }
};
</script>

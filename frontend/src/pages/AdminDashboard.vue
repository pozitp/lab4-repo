<template>
  <div class="screen">
    <div class="user-bar">
      <span>ADMIN DASHBOARD</span>
      <a class="link-back" @click="$router.push('/app')">← BACK TO APP</a>
    </div>

    <div class="box">
      <div class="box-title">FEATURE FLAGS</div>
      <table>
        <thead>
          <tr>
            <th>FLAG NAME</th>
            <th>STATUS</th>
            <th>ACTION</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="flag in flags" :key="flag.id">
            <td>{{ flag.name }}</td>
            <td>{{ flag.enabled ? 'ENABLED' : 'DISABLED' }}</td>
            <td>
              <button class="button" @click="toggleFlag(flag.name)">
                TOGGLE
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdminDashboard",
  data() {
    return {
      flags: []
    };
  },
  async mounted() {
    await this.fetchFlags();
  },
  methods: {
    async fetchFlags() {
      try {
        const response = await fetch('/api/features');
        if (response.ok) {
          this.flags = await response.json();
        }
      } catch (error) {
        console.error('Failed to fetch flags:', error);
      }
    },
    async toggleFlag(name) {
      try {
        const response = await fetch(`/api/features/${name}/toggle`, {
          method: 'POST'
        });
        if (response.ok) {
          await this.fetchFlags();
        }
      } catch (error) {
        console.error('Failed to toggle flag:', error);
      }
    }
  }
};
</script>

import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// // https://vite.dev/config/
// export default defineConfig({
//   plugins: [react()],
// })
// import { defineConfig } from 'vite';
// import react from '@vitejs/plugin-react';

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      // Proxy all requests to the backend server
      '/hotel': {
        target: 'http://localhost:8081', // Backend server URL
        changeOrigin: true, // Adjust origin for CORS
      },
      '/register': {
        target: 'http://localhost:8081',
        changeOrigin: true,
      },
      '/login': {
        target: 'http://localhost:8081',
        changeOrigin: true,
      },
    },
  },
});
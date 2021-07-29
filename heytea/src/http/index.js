import axios from 'axios'

<<<<<<< HEAD
axios.defaults.baseURL = 'http://localhost:8000';
=======
axios.defaults.baseURL = 'http://120.79.152.10:8000';
>>>>>>> 649d61f7ca73d5170d3d48c0b8677c9039116e4b
axios.defaults.timeout = 10000;
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

export default axios;
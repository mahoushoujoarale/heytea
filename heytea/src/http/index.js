import axios from 'axios'

axios.defaults.baseURL = 'http://120.79.152.10:8000';
axios.defaults.timeout = 10000;
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

export default axios;
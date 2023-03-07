 import axios from 'axios';
export const itemsService = () => new Promise((resolve) => {
	axios('http://localhost:8080/api/items')
		.then(res => {
			const items = res.data
			//const data = HomeContent;
			console.log(items)
			resolve({ items });
		}).catch((err) => {
			console.error(err);
			resolve([])
		})
})
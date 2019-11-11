const express = require('express');
const router = express.Router();

router.get('/', (req, res, next) => {
	res.status(200).json ({
	    message: 'Obteniendo'
	});
});

router.post('/', (req, res, next) => {
	res.status(200).json ({
	    message: 'Posteando'
	});
});

module.exports = router;

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

router.get('/:NodeID', (req, res, next) => {
	const id = req.params.NodeID;
	if (id === 'nodo1'){
		res.status(200).json({
		    message: 'id encontrado',
		    id: id
	});
	}else{
	   res.status(200).json({
	       message: 'pasaste un id'
	   });
	}
});
router.patch('/:NodeID', (req, res, next) => {
	res.status(200).json({
		message: 'Nodo Actualizado'
	})
})
router.delete('/:NodeID', (req, res, next) => {
	res.status(200).json({
		message: 'Nodo Borrado'
	})
})

module.exports = router;

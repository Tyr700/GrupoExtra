document.addEventListener('DOMContentLoaded', function() {
    const feedbackForm = document.getElementById('feedbackForm');
    
    if (feedbackForm) {
        feedbackForm.addEventListener('submit', async function(e) {
            e.preventDefault();
            
            const email = document.getElementById('email').value;
            const feedback = document.getElementById('feedback').value;
            
            try {
                const response = await fetch('/feedback/feedback', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        email: email,
                        feedback: feedback
                    })
                });
                
                if (response.ok) {
                    alert('Feedback enviado com sucesso! Obrigado por sua contribuição.');
                    feedbackForm.reset();
                } else {
                    alert('Erro ao enviar feedback. Por favor, tente novamente.');
                }
            } catch (error) {
                console.error('Erro:', error);
                alert('Erro ao enviar feedback. Por favor, tente novamente.');
            }
        });
    }
}); 
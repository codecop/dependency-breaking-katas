using System.Windows.Forms;

namespace Org.Codecop.Dependencies.E
{
    public class UserConfirmation
    {
        public bool Accepted { get; private set; }

        public UserConfirmation(string message)
        {
            var result = MessageBox.Show(
                message,
                "Confirm",
                MessageBoxButtons.OK,
                MessageBoxIcon.Question,
                MessageBoxDefaultButton.Button1);
            this.Accepted = result == DialogResult.Yes;
        }
    }

}

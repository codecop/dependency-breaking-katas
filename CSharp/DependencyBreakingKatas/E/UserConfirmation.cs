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
                "Choose Option",
                MessageBoxButtons.YesNoCancel,
                MessageBoxIcon.Question,
                MessageBoxDefaultButton.Button1);

            this.Accepted = result == DialogResult.Yes;
        }
    }

}

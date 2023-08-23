#ifndef E_USER_CONFIRMATION_H
#define E_USER_CONFIRMATION_H

typedef struct E_UserConfirmation E_UserConfirmation;

E_UserConfirmation* E_UserConfirmation_create(const char* message);
void E_UserConfirmation_destroy(E_UserConfirmation* self);
void E_UserConfirmation_display(E_UserConfirmation* self);
int E_UserConfirmation_isAccepted(const E_UserConfirmation* self);

#endif // E_USER_CONFIRMATION_H

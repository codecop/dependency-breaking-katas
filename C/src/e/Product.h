#ifndef E_PRODUCT_H
#define E_PRODUCT_H

typedef struct E_Product E_Product;

const E_Product* E_Product_create(const char* name);
void E_Product_destroy(const E_Product* self);

const char* E_Product_name(const E_Product* self);

#endif // E_PRODUCT_H

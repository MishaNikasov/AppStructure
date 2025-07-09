:app                         // точка входу (MainActivity, DI root)
:core:ui                     // компоненти UI
:core:design                 // тема, шрифти, кольори, іконкиб, спейсинг
:core:network                // Retrofit, interceptors
:core:database               // Room 
:core:common                 // extensions, helpers, DateFormatter и т.д.

:domain:auth                 // інтерфейси, use cases, моделі (auth)
:domain:user                 // ..

:data:auth                   // реалізація AuthRepository
:data:user                   // ..

:features:login              // UI + ViewModel..
:features:onboarding         // ..
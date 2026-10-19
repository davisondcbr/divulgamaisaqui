# DIVULGAMAISAQUI Android TV Box

Projeto Android WebView que carrega o reprodutor já publicado em `https://davisondcbr.github.io/divulgamaisaqui/tv.html`.

## Gerar APK no GitHub
1. Extraia o ZIP e envie **todos** os arquivos/pastas à raiz do repositório `davisondcbr/divulgamaisaqui`, preservando `.github/workflows/android-apk.yml`. Mantenha também `index.html` e `tv.html` na raiz.
2. GitHub → **Actions** → **Gerar APK DIVULGAMAISAQUI** → **Run workflow**.
3. Abra a execução concluída → **Artifacts** → baixe `DIVULGAMAISAQUI-APK` (ZIP). Dentro estará `app-debug.apk`.
4. Instale em uma TV Box para testes (habilite instalação por fonte externa conforme o modelo). O mesmo APK funciona em várias TV Boxes; cada uma usa seu próprio código e chave de ativação na tela do reprodutor.

## Limitações importantes
- O APK depende da URL do GitHub Pages e do Supabase; não baixa vídeos para reprodução offline nesta versão.
- O modo imersivo oculta navegação, mas sem provisionamento como **Device Owner**, não bloqueia os menus do sistema nem o desligamento. A inicialização automática depende de políticas da versão Android e firmware da TV Box.
- O modo quiosque (lock task) é habilitado automaticamente **somente quando o aplicativo já foi provisionado como Device Owner**. Esse provisionamento precisa ser planejado e testado no aparelho; não é realizado pela simples instalação do APK.
- APK `debug` é para testes, não distribuição pública. O build de release precisa de assinatura segura, versionamento e controles de atualização.
- WebView instalado no dispositivo deve ser atualizado; alguns modelos TV Box antigos não suportam corretamente codecs, WebView ou inicialização em boot.
- O reprodutor `tv.html` deve salvar o código/chave após ativação para reconectar automaticamente; o projeto disponibilizado com este pacote inclui essa melhoria.
- O painel administrativo usa autenticação Supabase; não embuta senhas administrativas no APK.
